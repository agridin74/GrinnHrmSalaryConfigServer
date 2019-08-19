/**
 * @author Alex Gridin
 */
import { Injectable } from '@angular/core';
import { Slrkadr } from './slrkadr';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { HandleError, HttpErrorHandler} from '../error.service';


@Injectable()
export class SlrkadrService {

  entityUrl = environment.REST_API_URL + 'slrkadr/slrkadrs';
  private readonly handlerError: HandleError;

  constructor(private http: HttpClient, private httpErrorHandler: HttpErrorHandler) {
    this.handlerError = httpErrorHandler.createHandleError('SlrkadrService');
   }

   getSlrkadrs(): Observable<Slrkadr[]>{
     return this.http.get<Slrkadr[]>(this.entityUrl)
      .pipe(
        catchError(this.handlerError('getSlrkadrs', []))
      );
   }

   getSlrkadrById(slrkadrId: string): Observable<Slrkadr>{
     return this.http.get<Slrkadr>(this.entityUrl + '/' + slrkadrId)
      .pipe(
        catchError(this.handlerError('getSlrkadrById', {} as Slrkadr))
      );
   }

   addSlrkadr(slrkadr: Slrkadr): Observable<Slrkadr> {
     return this.http.post<Slrkadr>(this.entityUrl, slrkadr)
      .pipe(catchError(this.handlerError('AddSlrkadr', slrkadr))
      );
   }

   updateSlrkadr(slrkadrId: string, slrkadr: Slrkadr): Observable<{}>{
     return this.http.put<Slrkadr>(this.entityUrl + '/' + slrkadrId, slrkadr)
      .pipe(
        catchError(this.handlerError('updateSlrkadr', slrkadr))
      );
   }

   deleteSlrkadr(slrkadrId: string): Observable<{}> {
     return this.http.delete<Slrkadr>(this.entityUrl + '/' + slrkadrId)
      .pipe(
        catchError(this.handlerError('deleteSlrkadr',[slrkadrId]))
      );
   }
}
