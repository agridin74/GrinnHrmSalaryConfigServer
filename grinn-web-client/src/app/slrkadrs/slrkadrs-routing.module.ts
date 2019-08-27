/**
 * Модуль маршрутизации для физ лиц.
 * @author Alex Gridin
 */
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SlrkadrListComponent } from './slrkadr-list/slrkadr-list.component';
import { SlrkadrEditComponent } from './slrkadr-edit/slrkadr-edit.component';
import { SlrkadrDetailComponent } from './slrkadr-detail/slrkadr-detail.component';
import { SlrkadrAddComponent } from './slrkadr-add/slrkadr-add.component';
import { AuthGaurdService } from '../auth/auth-gaurd.service';

const slrkadrRoutes: Routes = [
  {path: 'slrkadrs' , component: SlrkadrListComponent, canActivate: [AuthGaurdService]},
  {path: 'slrkadrs/add', component: SlrkadrAddComponent, canActivate: [AuthGaurdService]},
  {path: 'slrkadrs/:id', component: SlrkadrDetailComponent, canActivate: [AuthGaurdService]},
  {path: 'slrkadrs/:id/edit', component: SlrkadrEditComponent, canActivate: [AuthGaurdService]}
];

@NgModule({
    imports: [RouterModule.forChild(slrkadrRoutes)],
    exports: [RouterModule]
})
export class SlrkadrsRoutingModule { }
