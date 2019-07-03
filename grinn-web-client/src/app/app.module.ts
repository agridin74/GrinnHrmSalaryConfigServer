import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateSlrdepartmentComponent } from './components/slrdepartment/create-slrdepartment/create-slrdepartment.component';
import { SlrdepartmentDetailsComponent } from './components/slrdepartment/slrdepartment-details/slrdepartment-details.component';
import { SlrdepartmentListComponent } from './components/slrdepartment/slrdepartment-list/slrdepartment-list.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    CreateSlrdepartmentComponent,
    SlrdepartmentDetailsComponent,
    SlrdepartmentListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
