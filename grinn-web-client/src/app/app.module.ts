import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { PartsModule} from './parts/parts.module';
/**
 * todo переделать в модуль справочник подразделений
 * в дальнейшем импортировать модули
 * 
 */

import {HttpErrorHandler} from './error.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    
    ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    PartsModule,
    //добавить пользовательские модули
    BrowserAnimationsModule,
    AppRoutingModule
    ],
  providers: [
    HttpErrorHandler,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
