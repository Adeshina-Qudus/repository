package data.repositories;

import data.models.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImplementation implements EntryRepository{
    private List<Entry> entries = new ArrayList<>();
    private int count;
    @Override
    public Entry save(Entry entry) {
        if (isNew(entry)) createNew(entry);
        else update(entry);
        return entry;
    }

    private void createNew(Entry entry) {
        count++;
        entry.setId(generateId());
        entries.add(entry);
    }

    private boolean isNew(Entry entry) {
        return entry.getId() == 0;
    }
    private void update(Entry entry) {
        Entry oldEntry = findById(entry.getId());
        entries.remove(oldEntry);
        entries.add(entry);
    }
    private int generateId() {
        return count;
    }
    @Override
    public List<Entry> findAll() {
        return entries;
    }
    @Override
    public Entry findById(int id) {
        for (Entry entry : entries){
            if (entry.getId() == id)return entry;
        }
        return null;
    }
    @Override
    public Entry findByEntryIdAndDiaryId(int entryId, int diaryId) {
        Entry entry = findById(entryId);
        if (entry.getDiaryId() == diaryId) return entry;
        return null;
    }
    @Override
    public void delete(int id) {
       Entry entry = findById(id);
           entries.remove(entry.getId());
           count--;
    }

    @Override
    public void delete(Entry entry) {
        for (Entry entry1 : entries){
            if (entry1 == entry){
                entries.remove(entry);
                count--;
            }
        }
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public void clear() {
        entries.clear();
    }
}
