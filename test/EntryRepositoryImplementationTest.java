import data.models.Diary;
import data.models.Entry;
import data.repositories.EntryRepository;
import data.repositories.EntryRepositoryImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntryRepositoryImplementationTest {

    private EntryRepository entryRepository;
    @BeforeEach
    public void startAllTestsWith(){
        entryRepository = new EntryRepositoryImplementation();
    }
    @Test
    public void saveOneEntry_countIsOneTest(){
        Entry entry = new Entry();
        entryRepository.save(entry);
        assertEquals(1,entryRepository.count());
    }
    @Test
    public void saveTwoEntry_countIsOneAndTwoTest(){
        Entry entry = new Entry();
        entryRepository.save(entry);
        assertEquals(1,entryRepository.count());
    }
    @Test
    public void saveTwoEntry_findAllCountReturnsTest(){
        Entry entry = new Entry();
        Entry secondEntry = new Entry();
        entryRepository.save(entry);
        entryRepository.save(secondEntry);
        assertEquals(2,entryRepository.findAll().size());
    }
    @Test
    public void saveNewEntry_idIsOneTest(){
        Entry entry = new Entry();
        assertEquals(0, entry.getId());
        entryRepository.save(entry);
        assertEquals(1,entry.getId());
    }

    @Test
    public void saveUpdatedEntry_doesNotInfluenceCountTest(){
        Entry entry = new Entry();
        entryRepository.save(entry);
        Entry updatedEntry = new Entry();
        updatedEntry.setId(1);
        entryRepository.save(updatedEntry);
        assertEquals(1,entryRepository.count());
        assertEquals(updatedEntry,entryRepository.findById(1));
    }
    @Test
    public void findByEntryIdAndDiaryIdTest(){
        Entry entry = new Entry();
        entryRepository.save(entry);
        entry.setDiaryId(101);
        assertEquals(entry, entryRepository.findByEntryIdAndDiaryId(1,101));
    }

    @Test
    public void deleteByIdTest(){
        Entry entry = new Entry();
        Entry entry2 = new Entry();
        entryRepository.save(entry);
        entryRepository.save(entry2);
        entryRepository.delete(entry.getId());
        assertEquals(1,entryRepository.count());
    }
    @Test
    public void deleteByEntryTest(){
        Entry entry = new Entry();
        Entry entry2 = new Entry();
        entryRepository.save(entry);
        entryRepository.save(entry2);
        entryRepository.delete(entry);
        assertEquals(1,entryRepository.count());
    }
    @Test
    public void clearEntryTest(){
        Entry entry = new Entry();
        Entry entry2 = new Entry();
        entryRepository.save(entry);
        entryRepository.save(entry2);
        entryRepository.clear();
        assertEquals(0,entryRepository.findAll().size());
    }

}
