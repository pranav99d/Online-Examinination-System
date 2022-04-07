import { Component, OnInit } from '@angular/core';
import { User } from "src/app/model/user";
import { ForgotPasswordService } from "src/app/services/forgot-password.service";

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  credentials = {
    id: '',
    username: '',
    password: '',
    password1: ''
  }

  users !: Array<User>;

  constructor(private forgotPasswordService: ForgotPasswordService) { }

  ngOnInit(): void {
  }

  getUser() {
    this.forgotPasswordService.getUsers().subscribe(
      response => this.handleSuccessfulResponse(response),
    );
  }

  handleSuccessfulResponse(response: any) {
    this.users = response;
  }

  onSubmit() {
    if ((this.credentials.username != '' && this.credentials.password != '' && this.credentials.password1 != '') && (this.credentials.username != null && this.credentials.password != null && this.credentials.password1 != null) && (this.credentials.password == this.credentials.password1))
    {
      console.log("We have update password here!");
      this.forgotPasswordService.updateToken(this.credentials).subscribe(
        (response:any)=>{
          console.log("response");
          this.forgotPasswordService.getUsers();
          alert("Password Updated Successfully!!!");
          window.location.href="/login";
        },
        (error:any)=>{
          console.log("error");
        }
      )
    } else {
      console.log("Fields are required!");
    }

  }

}
