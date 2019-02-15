import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Company} from "../model/company";


@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  private url: string = '/api/companies';

  constructor(private http: HttpClient) {}

  getAllCompanies(): Observable<Company[]> {
    return this.http.get<Company[]>(this.url);
  }

  saveCompany(company: Company): Observable<Company> {
    return this.http.post<Company>(this.url, company);
  }

  deleteCompany(companyId: string): Observable<void> {
    return this.http.delete<void>(this.url + '/' + companyId);
  }

}
