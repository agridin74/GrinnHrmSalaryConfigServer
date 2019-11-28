import {Slrdepartment} from './slrdepartment';

export interface TreeItem {
    data: Slrdepartment | null;
    children: TreeItem[];
}
