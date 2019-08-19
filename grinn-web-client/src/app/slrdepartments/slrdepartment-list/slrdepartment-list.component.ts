/**
 * @author Alex Gridin
 */
import { Component, OnInit } from '@angular/core';
import { SlrdepartmentService } from '../slrdepartment.service';
import { Slrdepartment } from '../slrdepartment';
import { Router } from '@angular/router'; 



@Component({
  selector: 'app-slrdepartment-list',
  templateUrl: './slrdepartment-list.component.html',
  styleUrls: ['./slrdepartment-list.component.css']
})
export class SlrdepartmentListComponent implements OnInit {
  errorMessage: string;
  slrdepartments: Slrdepartment[];
  
  constructor(private router: Router, private slrdepartmentService: SlrdepartmentService ) { }

  ngOnInit() {
    this.slrdepartmentService.getSlrdepartments().subscribe(
      slrdepartments => this.slrdepartments = slrdepartments,
      error => this.errorMessage = error as any
    );
  }

  onSelect(slrdepartment: Slrdepartment){
    this.router.navigate(['/slrdeaprtments', slrdepartment.id]);
  }

  addSlrdepartment(){
    this.router.navigate(['/slrdepartments/add']);
  }
}
