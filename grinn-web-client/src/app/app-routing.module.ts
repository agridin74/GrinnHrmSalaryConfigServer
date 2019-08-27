import { NgModule } from '@angular/core';
import { RouterModule , Routes, } from '@angular/router';
import { PageNotFoundComponent} from './parts/page-not-found/page-not-found.component';
import { WelcomeComponent} from './parts/welcome/welcome.component';
import { LoginComponent} from './auth/login/login.component';
import { LogoutComponent } from './auth/logout/logout.component';
import { AuthGaurdService } from './auth/auth-gaurd.service';

const appRoutes: Routes = [
  { path: 'welcome', component: WelcomeComponent},
  { path: '', component: WelcomeComponent},
  { path: 'login', component: LoginComponent},
  { path: 'logout', component: LogoutComponent, canActivate: [AuthGaurdService]},
  { path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
