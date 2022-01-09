package general.user_cases.member.domain;

public final class Company {
   private String name;
   private CompanyId id;

    public Company(String name, CompanyId id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public CompanyId getId() {
        return id;
    }
}
