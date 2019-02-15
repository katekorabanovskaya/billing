import {Injectable} from "@angular/core";
import {Token} from "./model/token";

const TOKEN_KEY = 'AuthToken';
const LOGIN_KEY = 'Login';
const ROLE_KEY = 'Role';

@Injectable()
export class TokenStorage {

  constructor() {
  }

  public saveToken(token: string) {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);

    let decodeJwt: Token = this.decodeJwt(token);
    window.sessionStorage.setItem(LOGIN_KEY, decodeJwt.sub);
    window.sessionStorage.setItem(ROLE_KEY, decodeJwt.scopes);
  }

  public signOut() {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.removeItem(LOGIN_KEY);
    window.sessionStorage.removeItem(ROLE_KEY);

    window.sessionStorage.clear();
  }

  public getToken(): string {
    return sessionStorage.getItem(TOKEN_KEY);
  }

  public getLogin(): string {
    return sessionStorage.getItem(LOGIN_KEY);
  }

  public getRole(): string {
    return sessionStorage.getItem(ROLE_KEY);
  }

  public isLogin(): boolean {
    return sessionStorage.getItem(TOKEN_KEY) !== null;
  }

  private decodeJwt(token: string): Token {
    let encodedJwt = token.split('.')[1];
    let decodedJwt = window.atob(encodedJwt);
    return JSON.parse(decodedJwt);
  }
}
