import { Injectable } from '@angular/core';
import { Slrdepartment } from './slrdepartment';
import { Slrfactory } from './slrfactory';
import { Slrbranches } from './srbranches';
import { Observable, from } from 'rxjs';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { HandleError, HttpErrorHandler } from '../error.service';



@Injectable()
export class SlrdepartmentService {
  entityUrl = environment.REST_API_URL +  'department/slrdepartments';
  private readonly handlerError: HandleError;
  //private baseUrl ='http://172.16.0.237:8080/api/department/slrdepartments';
  //private baseUrl ='/api/department/slrdepartments';

  constructor(private http: HttpClient, private httpErrorHandler: HttpErrorHandler) { 
    this.handlerError = httpErrorHandler.createHandleError('SlrdepartmentService');
  }

  getSlrdepartments(): Observable<Slrdepartment[]>{
    return this.http.get<Slrdepartment[]>(this.entityUrl)
      .pipe(
        catchError(this.handlerError('getSlrdepartments', []))
      );
  }

  getSlrdepartmentById(entityId: string): Observable<Slrdepartment>{
    return this.http.get<Slrdepartment>(this.entityUrl + '/' + entityId)
      .pipe(
        catchError(this.handlerError('getSlrdepartmentById', {} as Slrdepartment))
      );
  }

  addSlrdepartment(entity: Slrdepartment): Observable<Slrdepartment>{
    return this.http.post<Slrdepartment>(this.entityUrl, entity)
      .pipe(
        catchError(this.handlerError('addSlrdepartment', entity))
      );
  }

  updateSlrdepartment(entityId: string, entity: Slrdepartment): Observable<{}>{
    return this.http.put<Slrdepartment>(this.entityUrl + '/' + entityId, entity)
      .pipe(
        catchError(this.handlerError('updateSlrdepartment', entity))
      );
  }

  deleteSlrdepartment(entityId: string): Observable<{}> {
    return this.http.delete<Slrdepartment>(this.entityUrl + '/' + entityId)
      .pipe(
        catchError(this.handlerError('deleteSlrdepartment', [entityId]))
      );
  }
  /*getSlrdepartment(id: number): Observable<any>{
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
  }*/
}
