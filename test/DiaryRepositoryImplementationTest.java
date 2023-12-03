import data.models.Diary;
import data.models.Entry;
import data.repositories.DiaryRepository;
import data.repositories.DiaryRepositoryImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiaryRepositoryImplementationTest {

    private DiaryRepository diaryRepository;
    @BeforeEach
    public void startAllTestsWith(){
        diaryRepository = new DiaryRepositoryImplementation();
    }
    @Test
    public void saveOneDiary_countIsOneTest(){
        Diary diary = new Diary();
        diaryRepository.save(diary);
        assertEquals(1,diaryRepository.count());
    }
    @Test
    public void saveTwoDiary_foundAllCountReturnsTest(){
        Diary diary = new Diary();
        Diary secondDiary = new Diary();
        Diary thirdDiary = new Diary();
        diaryRepository.save(diary);
        diaryRepository.save(secondDiary);
        diaryRepository.save(thirdDiary);
        assertEquals(3,diaryRepository.findAll().size());
    }
    @Test
    public void saveUpdatedDiary_doesNotInfluenceCountTest(){
        Diary diary = new Diary();
        diaryRepository.save(diary);
        Diary updatedDiary = new Diary();
        updatedDiary.setId(1);
        diaryRepository.save(updatedDiary);
        assertEquals(1,diaryRepository.count());
        assertEquals(updatedDiary,diaryRepository.findById(1));
    }
    @Test
    public void findByDiaryIdAndEntryIdTest(){
        Diary diary = new Diary();
        diaryRepository.save(diary);
        diary.setEntryId(101);
        assertEquals(diary, diaryRepository.findByEntryIdAndDiaryId(101,1));
    }
    @Test
    public void deleteDiaryByIdTest(){
        Diary diary = new Diary();
        Diary secondDiary = new Diary();
        diaryRepository.save(diary);
        diaryRepository.save(secondDiary);
        diaryRepository.delete(diary.getId());
        assertEquals(1,diaryRepository.count());
    }
    @Test
    public void deleteDiaryByDiaryTest(){
        Diary diary = new Diary();
        Diary secondDiary = new Diary();
        diaryRepository.save(diary);
        diaryRepository.save(secondDiary);
        diaryRepository.delete(diary);
        assertEquals(1,diaryRepository.count());
    }
    @Test
    public void clearDiaryTest(){
        Diary diary = new Diary();
        Diary secondDiary = new Diary();
        diaryRepository.save(diary);
        diaryRepository.save(secondDiary);
        diaryRepository.clear();
        assertEquals(0,diaryRepository.findAll().size());
    }





}
