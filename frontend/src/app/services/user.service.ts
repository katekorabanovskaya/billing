import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../model/user";


@Injectable({
  providedIn: 'root'
})
export class UserService {

  private url: string = 'api/users';

  constructor(private http: HttpClient) {
  }

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.url);
  }

  // getUser(userId: string): Observable<User> {
  //   return this.http.get<User>(this.url + '/' + userId);
  // }

  saveUser(user: User): Observable<User> {
    return this.http.post<User>(this.url + '/signin', user);
  }

  deleteUser(userId: string): Observable<void> {
    return this.http.delete<void>(this.url + '/' + userId);
  }

  // getCurrentUser(): Observable<User> {
  //   let userId: number = 3;
  //   return this.http.get<User>(this.url + '/' + userId);
  // }
}
