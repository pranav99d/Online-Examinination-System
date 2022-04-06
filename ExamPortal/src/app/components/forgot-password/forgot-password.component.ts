import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  credentials = {
    username: '',
    password: '',
    password1: ''
  }

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(){

  }

}
