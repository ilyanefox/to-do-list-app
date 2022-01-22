import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Task} from "./task";

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private http: HttpClient) {
  }

  public addTask(task: Task): Observable<Task> {
    return this.http.post<any>("http://localhost:8080/task/add", task);
  }

  public getTasks(): Observable<Task[]> {
    return this.http.get<Task[]>("http://localhost:8080/task/list")
  }

  public getTaskByCategory(): Observable<Task[]> {
    return this.http.get<Task[]>("http://localhost:8080/task/list/{category}")
  }
}
