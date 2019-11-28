import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { PartsModule } from './parts/parts.module';
import { SlrdepartmentsModule } from './slrdepartments/slrdepartments.module';
import { SlrkadrsModule } from './slrkadrs/slrkadrs.module';
import { UsrslrpaymentprizeModule } from './usrslrpaymentprize/usrslrpaymentprize.module';
import { AuthModule } from './auth/auth.module';
import { HttpErrorHandler } from './error.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatNativeDateModule } from '@angular/material/core';
import { MaterialModule } from './material.module';






@NgModule({
  declarations: [
    AppComponent,
    
    ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    PartsModule,
    SlrdepartmentsModule,
    SlrkadrsModule,
    UsrslrpaymentprizeModule,
    AuthModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    MatNativeDateModule,
    MaterialModule
    
    ],
  providers: [
    HttpErrorHandler,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
