import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule} from '@angular/forms';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { WelcomeComponent } from './welcome/welcome.component';

@NgModule({
  declarations: [
    PageNotFoundComponent,
    WelcomeComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports: [
    PageNotFoundComponent,
    WelcomeComponent
  ]
})
export class PartsModule { }
