/**
 * @author Alex Gridin
 */
import { Component, OnInit } from '@angular/core';
import { SlrkadrService } from '../slrkadr.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Slrkadr } from '../slrkadr';

@Component({
  selector: 'app-slrkadr-detail',
  templateUrl: './slrkadr-detail.component.html',
  styleUrls: ['./slrkadr-detail.component.css']
})
export class SlrkadrDetailComponent implements OnInit {
  errorMessage: string;
  slrkadr: Slrkadr;

  constructor(private route: ActivatedRoute, private router: Router, private slrkadrService: SlrkadrService) {
    this.slrkadr = {} as Slrkadr;
   }

  ngOnInit() {
    const slrkadrId = this.route.snapshot.params.id;
    this.slrkadrService.getSlrkadrById(slrkadrId).subscribe(
      slrkadr => this.slrkadr = slrkadr,
      error => this.errorMessage = error as any
    );

  }

  gotoSlrkadrsList(){
    this.router.navigate(['/slrkadrs']);
  }

  editSlrkadr(){
    this.router.navigate(['/slrkadrs', this.slrkadr.id, 'edit']);
  }

}
