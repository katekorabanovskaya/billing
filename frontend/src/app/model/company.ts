
export class Company {

  companyId: string;
  companyName: string;
  companyDomainName: string;

  static cloneBase(clonedCompany: Company): Company {
    let company: Company = new Company();
    company.companyId = clonedCompany.companyId;
    company.companyName = clonedCompany.companyName;
    company.companyDomainName = clonedCompany.companyDomainName;
    return company;
  }
}
