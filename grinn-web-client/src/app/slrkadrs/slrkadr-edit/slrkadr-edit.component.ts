/**
 * @author Alex Gridin
 */
import { Component, OnInit } from '@angular/core';
import { SlrkadrService } from '../slrkadr.service';
import { Slrkadr } from '../slrkadr';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-slrkadr-edit',
  templateUrl: './slrkadr-edit.component.html',
  styleUrls: ['./slrkadr-edit.component.css']
})
export class SlrkadrEditComponent implements OnInit {
  slrkadr: Slrkadr;
  errorMessage: string; // server error message

  constructor(private slrkadrService: SlrkadrService, private route: ActivatedRoute, private router: Router) {
    this.slrkadr = {} as Slrkadr;
   }

  ngOnInit() {
    const slrkadrId = this.route.snapshot.params.id;
    this.slrkadrService.getSlrkadrById(slrkadrId).subscribe(
      slrkadr => this.slrkadr = slrkadr,
      error => this.errorMessage = error as any);
  }

  onSubmit(slrkadr: Slrkadr) {
    const that = this;
    this.slrkadrService.updateSlrkadr(slrkadr.id.toString(), slrkadr).subscribe(
      result => this.gotoSlrkadrDetail(slrkadr),
      error => this.errorMessage = error as any
    );
  }

  gotoSlrkadrDetail(slrkadr: Slrkadr){
    this.errorMessage = null;
    this.router.navigate(['/slrkadrs', slrkadr.id]);
  }

}
