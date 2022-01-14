import { Injectable } from '@angular/core';
import {User} from "./user";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor( private _http : HttpClient) { }

  public loginUserFromRemote(user : User):Observable<any> {
    return this._http.post<any>("http://localhost:8080/ta-da-list/login", user)
  }

  public registerUserFromRemote(user : User):Observable<any> {
    return this._http.post<any>("http://localhost:8080/ta-da-list/register", user)
  }

  public findUserByFirstName(user : User): Observable<User> {
    return this._http.post<User>("http://localhost:8080/ta-da-list/profile", user)
  }
}
