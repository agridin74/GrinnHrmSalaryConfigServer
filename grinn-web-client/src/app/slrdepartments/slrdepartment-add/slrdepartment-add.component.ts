/**
 * @author Alex Gridin
 */
import { Component, OnInit } from '@angular/core';
import { SlrdepartmentService } from '../slrdepartment.service';
import { Slrdepartment } from '../slrdepartment';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-slrdepartment',
  templateUrl: './slrdepartment-add.component.html',
  styleUrls: ['./slrdepartment-add.component.css']
})
export class CreateSlrdepartmentComponent implements OnInit {
  slrdepartment: Slrdepartment;
  errorMessage: string;
  /*slrdepartment: Slrdepartment = new Slrdepartment();
  submitted = false;*/

  constructor(private slrdepartmentService: SlrdepartmentService, private router: Router) {
    this.slrdepartment = {} as Slrdepartment;
   }

  ngOnInit() {
  }

  onSubmit( slrdepartment: Slrdepartment){
    slrdepartment.id=null;
    this.slrdepartmentService.addSlrdepartment(slrdepartment).subscribe(
      newSlrdepartment => {
        this.slrdepartment = newSlrdepartment,
        this.gotoSlrdepartmentList();
      },
      error => this.errorMessage = error as any
    );
  }

  gotoSlrdepartmentList(){
    this.router.navigate(['/slrdepartments']);
  }

  /*newSlrdepartment(): void {
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

*/
}
