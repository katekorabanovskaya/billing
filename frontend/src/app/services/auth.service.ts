import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http'
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private url: string = 'api/token/generate-token';

  constructor(private http: HttpClient) {
  }

  attemptAuth(login: string, password: string): Observable<any> {
    const userDetails = {login: login, password: password};
    return this.http.post<any>(this.url, userDetails);
  }
}
