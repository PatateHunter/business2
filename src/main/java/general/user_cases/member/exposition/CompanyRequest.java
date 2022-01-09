package general.user_cases.member.exposition;

public class CompanyRequest {
    public String companyName;
    public String companyId;

    @Override
    public String toString() {
        return "companyNameDTO{" +
                "companyName='" + companyName + '\'' +
                "companyId='" + companyId + '\'' +
                '}';
    }
}
