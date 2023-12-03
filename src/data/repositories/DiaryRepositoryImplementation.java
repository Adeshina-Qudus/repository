package data.repositories;

import data.models.Diary;
import java.util.ArrayList;
import java.util.List;

public class DiaryRepositoryImplementation implements DiaryRepository {

    private List<Diary> diaries = new ArrayList<>();
    private int count;
    @Override
    public Diary save(Diary diary) {
        if (isNew(diary)) createNew(diary);
        else update(diary);
        return diary;
    }

    private void update(Diary diary) {
        Diary oldDiary = findById(diary.getId());
        diaries.remove(oldDiary);
        diaries.add(diary);
    }

    private void createNew(Diary diary) {
        count++;
        diary.setId(generateId());
        diaries.add(diary);
    }

    private int generateId() {
        return count;
    }

    private boolean isNew(Diary diary) {
        return diary.getId() == 0;
    }

    @Override
    public List<Diary> findAll() {
        return diaries;
    }

    @Override
    public Diary findById(int id) {
        for (Diary diary : diaries){
            if (diary.getId() == id)return diary;
        }
        return null;
    }

    @Override
    public Diary findByEntryIdAndDiaryId(int entryId, int diaryId) {
        Diary diary = findById(diaryId);
        if (diary.getEntryId() == entryId) return diary;
        return null;
    }

    @Override
    public void delete(int id) {
        Diary diary = findById(id);
        diaries.remove(diary.getId());
        count--;
    }
    @Override
    public void delete(Diary diary) {
        Diary diary1 = findById(diary.getId());
        diaries.remove(diary1);
        count--;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public void clear() {
        diaries.clear();
    }
}