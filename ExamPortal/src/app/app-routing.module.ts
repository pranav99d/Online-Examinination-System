import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from "./components/home/home.component";
import { LoginComponent } from "./components/login/login.component";
import { DashboardComponent } from "./components/dashboard/dashboard.component";
import { ForgotPasswordComponent } from "./components/forgot-password/forgot-password.component";
import { AuthGuard } from "src/app/services/auth.guard";
import { AdminLoginComponent } from "./components/admin/components/admin-login/admin-login.component";
import { AdminDashboardComponent } from "./components/admin/components/admin-dashboard/admin-dashboard.component";
import { AdminForgotComponent } from "./components/admin/components/admin-forgot/admin-forgot.component";
import { AdminAuthGuard } from "src/app/components/admin/services/admin-auth.guard";

const routes: Routes = [

  {
      path : '',
      component : HomeComponent,
      pathMatch : 'full'
  },
  {
      path : "login",
      component : LoginComponent,
      pathMatch : 'full'
  },
  {
      path : "dashboard",
      component : DashboardComponent,
      pathMatch : 'full',
      canActivate : [AuthGuard]
  },
  {
      path : "forgot",
      component : ForgotPasswordComponent,
      pathMatch : 'full'
  },
  {
      path : "admin-login",
      component : AdminLoginComponent,
      pathMatch : 'full'
  },
  {
      path : "admin-dashboard",
      component : AdminDashboardComponent,
      pathMatch : 'full',
      canActivate : [AdminAuthGuard]
  },
  {
      path : "admin-forgot",
      component : AdminForgotComponent,
      pathMatch : 'full'
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
