/**
 * 
 * @author Alex Gridin
 */

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SlrkadrListComponent } from './slrkadr-list/slrkadr-list.component';
import { SlrkadrEditComponent } from './slrkadr-edit/slrkadr-edit.component';
import { SlrkadrDetailComponent } from './slrkadr-detail/slrkadr-detail.component';
import { SlrkadrAddComponent } from './slrkadr-add/slrkadr-add.component';
import { SlrkadrsRoutingModule } from './slrkadrs-routing.module';
import { SlrkadrService } from './slrkadr.service';
import { SlrkadrsItemComponent } from './slrkadrs-item/slrkadrs-item.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    SlrkadrsRoutingModule
  ],
  declarations: [
    SlrkadrListComponent,
    SlrkadrEditComponent,
    SlrkadrDetailComponent,
    SlrkadrAddComponent,
    SlrkadrsItemComponent
  ],
    exports: [
      SlrkadrListComponent,
      SlrkadrEditComponent,
      SlrkadrDetailComponent,
      SlrkadrAddComponent,
      SlrkadrsItemComponent
    ],
  providers: [SlrkadrService]
})
export class SlrkadrsModule { }
