import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CompanySubscription} from "../model/company-subscription";

@Injectable({
  providedIn: 'root'
})
export class CompanySubscriptionService {

  private url: string = '/api/subscriptions';

  constructor(private http: HttpClient) {}

  getAllCompanySubscriptions(): Observable<CompanySubscription[]> {
    return this.http.get<CompanySubscription[]>(this.url);
  }

  saveCompanySubscription(subscription: CompanySubscription): Observable<CompanySubscription> {
    return this.http.post<CompanySubscription>(this.url, subscription);
  }

  deleteCompanySubscription(subscriptionId: string): Observable<void> {
    return this.http.delete<void>(this.url + '/' + subscriptionId);
  }

  getCompanySubscriptionByUser(userId: string): Observable<CompanySubscription[]> {
    return this.http.get<CompanySubscription[]>(this.url + '/user/' + userId);
  }

  getCountSubscriptions(): Observable<number> {
    return this.http.get<number>(this.url + '/count');
  }

  getPatternNames(pattern: string): Observable<string[]> {
    return this.http.get<string[]>(this.url + '/pattern/' + pattern);
  }

  getPageSubscriptions(page: number, size: number, pattern?: string, category?: string): Observable<CompanySubscription[]> {
    let url: string = this.url + '/page/' + page + '/' + size;

    if (pattern || category) {
      url += '?';
    }
    if (pattern) {
      url += 'pattern=' + pattern;
    }
    if (category) {
      url += '&category=' + category;
    }
    return this.http.get<CompanySubscription[]>(url);
  }

}
