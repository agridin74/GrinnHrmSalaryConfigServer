/**
 * @author Alex Gridin
 */
import { Injectable } from '@angular/core';
import { Usrslrpaymentprize } from './usrslrpaymentprize';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { HandleError, HttpErrorHandler } from '../error.service';

@Injectable()
export class UsrslrpaymentprizeService {
  entityUrl = environment.REST_API_URL + '/payment-prize/usrslrpaymentprizes';

  private readonly handlerError: HandleError;

  constructor(private http: HttpClient, private httpErrorHandler: HttpErrorHandler) {
    this.handlerError = httpErrorHandler.createHandleError('usrslrpaymentprizeService');
   }

   getUsrslrpaymentprizes(): Observable<Usrslrpaymentprize[]>{
     return this.http.get<Usrslrpaymentprize[]>(this.entityUrl)
      .pipe(
        catchError(this.handlerError('getUsrslrpaymentprizeServices', []))
      );
   }

   getUsrslrpaymentprizeById(entityId: string): Observable<Usrslrpaymentprize>{
     return this.http.get<Usrslrpaymentprize>(this.entityUrl + '/' + entityId)
      .pipe(
        catchError(this.handlerError('getUsrslrpaymentprizeById', {} as Usrslrpaymentprize))
      );
   }

   addUsrslrpaymentprize(entity: Usrslrpaymentprize): Observable<Usrslrpaymentprize> {
     return this.http.post<Usrslrpaymentprize>(this.entityUrl, entity)
      .pipe(
        catchError(this.handlerError('addUsrslrpaymentprize', entity))
      );
   }

   updateUsrslrpaymentprize(entityId: string, entity: Usrslrpaymentprize): Observable<{}> {
     return this.http.put<Usrslrpaymentprize>(this.entityUrl + '/' + entityId, entity)
      .pipe(
        catchError(this.handlerError('updateUsrslrpaymentprize', entity))
      );
   }

   deleteUsrslrpaymentprize(entityId: string): Observable<{}> {
     return this.http.delete<Usrslrpaymentprize>(this.entityUrl + '/' + entityId)
      .pipe(
        catchError(this.handlerError('deleteUsrslrpaymentprize',[entityId]))
      );
   }


}
