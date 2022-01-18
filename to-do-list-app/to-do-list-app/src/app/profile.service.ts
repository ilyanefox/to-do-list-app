import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "./user";
import { Categories } from "./categories";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor( private _http : HttpClient) { }

  public getUser(user: User):Observable<User> {
    return this._http.get<User>("http://localhost:8080/ta-da-list/user")
  }

  public getCategories():Observable<Categories[]> {
    return this._http.get<Categories[]>("http://localhost:8080/ta-da-list/user/profile")
  }

  public addCategory(category: Categories[]): Observable<any> {
    return this._http.post<any>("http://localhost:8080/ta-da-list/profile", category)
  }
}
