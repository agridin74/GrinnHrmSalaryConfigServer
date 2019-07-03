import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class SlrdepartmentService {

  private baseUrl ='http://localhost:8080/api/department/slrdepartments';

  constructor(private http: HttpClient) { }

  getSlrdepartment(id: number): Observable<any>{
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createSlrdepartment(slrdepartment: Object): Observable<Object>{
    return this.http.post(`${this.baseUrl}`, slrdepartment);
  }

  updateSlrdepartment(id: number, value: any): Observable<Object>{
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteSlrdepartment(id: number): Observable<any>{
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text'});
  }

  getSlrdepartmentsList(): Observable<any>{
    return this.http.get(`${this.baseUrl}`);
  }
}
