/**
 * @author Alex Gridin
 */
import { Component, OnInit } from '@angular/core';
import { SlrkadrService } from '../slrkadr.service';
import { Slrkadr } from '../slrkadr';
import { Router } from '@angular/router'; 

@Component({
  selector: 'app-slrkadr-add',
  templateUrl: './slrkadr-add.component.html',
  styleUrls: ['./slrkadr-add.component.css']
})
export class SlrkadrAddComponent implements OnInit {
  slrkadr: Slrkadr;
  errorMessage: string;

  constructor(private slrkadrService: SlrkadrService, private router: Router) {

   }

  ngOnInit() {
  }

  onSubmit(slrkadr: Slrkadr) {
    slrkadr.id = null;
    this.slrkadrService.addSlrkadr(slrkadr).subscribe(
      newSlrkadr => {
        this.slrkadr = newSlrkadr;
        this.gotoSlrkadrList();
      },
      error => this.errorMessage = error as any
    );
  }
  gotoSlrkadrList(){
    this.router.navigate(['/slrkadrs']);
  }

}
