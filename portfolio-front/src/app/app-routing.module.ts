import { NgModule } from '@angular/core';
import { Routes, RouterModule, ExtraOptions } from '@angular/router';
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
  /* "useHash : true" is necessary because the glassfish app server where 
  this app will be hosted (AWS) is not configured to always return index */
  useHash : true,
  anchorScrolling : 'enabled'
} 

@NgModule({
  imports: [RouterModule.forRoot(routes, routerOptions)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
