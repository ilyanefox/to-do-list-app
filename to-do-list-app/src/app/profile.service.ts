import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "./user";
import { Category } from "./category";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor( private _http : HttpClient) { }

  public getUser(user: User):Observable<User> {
    return this._http.get<User>("http://localhost:8080/ta-da-list/user")
  }

  public getCategories():Observable<Category[]> {
    return this._http.get<Category[]>("http://localhost:8080/ta-da-list/user/profile")
  }

  public addCategory(category : Category): Observable<any> {
    return this._http.post<any>("http://localhost:8080/ta-da-list/user/profile", category)
  }
}
