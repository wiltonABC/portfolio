import { NgModule } from '@angular/core';
import { Routes, RouterModule, ExtraOptions } from '@angular/router';
import { AppComponent } from './app.component';
import { ProfileComponent } from './profile/profile.component';
import { NotFoundComponent } from './not-found/not-found.component';

const routes: Routes = [
  {
    path : '',
    pathMatch : 'full',
    redirectTo : 'profiles/1'
  },
  {
    path : 'profiles/:idProfile',
    component : ProfileComponent
  },
  {
    path : 'not-found/:err',
    component : NotFoundComponent
  },
  {
    path : '**',
    component : NotFoundComponent
  }
];

const routerOptions : ExtraOptions = {
  useHash : false,
  anchorScrolling : 'enabled'
} 

@NgModule({
  imports: [RouterModule.forRoot(routes, routerOptions)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
