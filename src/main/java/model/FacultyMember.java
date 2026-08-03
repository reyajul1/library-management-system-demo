package model;

public class FacultyMember extends Member {
    public FacultyMember(String memberId, String name) {
        super(memberId, name);
    }

    @Override
    public int getMaxBooksAllowed() {
        return 5;
    }
}