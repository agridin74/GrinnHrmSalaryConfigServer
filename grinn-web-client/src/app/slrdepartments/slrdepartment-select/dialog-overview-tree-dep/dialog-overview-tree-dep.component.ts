import { Component,  EventEmitter, Input, Output, Inject } from '@angular/core';
import { SlrdepartmentService } from '../../slrdepartment.service';
import { Slrdepartment } from '../../slrdepartment';
import { NestedTreeControl } from '@angular/cdk/tree';
import { MatTreeNestedDataSource } from '@angular/material/tree';
import { TreeItem } from '../../tree-item';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { DialogData } from '../../dialog-data';




@Component({
  selector: 'app-dialog-overview-tree-dep',
  templateUrl: './dialog-overview-tree-dep.component.html',
  styleUrls: ['./dialog-overview-tree-dep.component.css']
})
export class DialogOverviewTreeDepComponent  {
  treeItem: TreeItem[];
  treeControl = new NestedTreeControl<TreeItem>(node => node.children);
  dataSource = new MatTreeNestedDataSource<TreeItem>();

  constructor( public dialogRef: MatDialogRef<DialogOverviewTreeDepComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) {
      this.treeItem = data.treeItem;
      this.dataSource.data = this.treeItem;
     }

  hasChild = (_: number, node: TreeItem) => !!node.children && node.children.length > 0;
  
  onNoClick(slrdepartment: Slrdepartment): void {
    this.dialogRef.close(slrdepartment);
  }
}
