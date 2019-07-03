import { Slrfactory } from './slrfactory';
import { Slrbranches } from './srbranches';

export class Slrdepartment{
    id: number;
    idparent: number;
    snm: string;
    codinref: number;
    idcard: number;
    sremark: string;
    smnemocode: string;
    slevel: string;
    snmlong: string;
    dbegin: string;
    dend: string;
    dendorder: string;
    dendclose: string;
    llist: string;
    lhide: string;
    lnvd: string;
    lnoishl: string;
    idfactory: Slrfactory;
    idbranches: Slrbranches;
}
