import { Component, OnInit } from '@angular/core';
import { SlrdepartmentService } from '../../../services/slrdepartment.service';
import { Slrdepartment } from '../../../entity/slrdepartment';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-slrdepartment',
  templateUrl: './create-slrdepartment.component.html',
  styleUrls: ['./create-slrdepartment.component.css']
})
export class CreateSlrdepartmentComponent implements OnInit {

  slrdepartment: Slrdepartment = new Slrdepartment();
  submitted = false;

  constructor(private slrdepartmentService: SlrdepartmentService,
    private router: Router) { }

  ngOnInit() {
  }

  newSlrdepartment(): void {
    this.submitted = false;
    this.slrdepartment = new Slrdepartment();
  }

  save() {
    this.slrdepartmentService.createSlrdepartment(this.slrdepartment)
      .subscribe(data => console.log(data), error => console.log(error));
    this.slrdepartment = new Slrdepartment();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/slrdepatments']);
  }

}
