/**
 * @author Alex Gridin
 */
export interface Usrslrpaymentprize {
    id: number;
    idfactory: number;
    idbranches: number;
    iddepartment: number;
    snm: string;
    idkadr: number;
    idincome: number;
    nmoney: number;
    nmoneyvichet: number;
    ntaxprc: number;
    ntaxmoney: number;
    dperiod: Date;
    dperiodfrom: Date;
    dperiodfromuser: Date;
    dfactpayed: Date;
    dperiodtax: Date;
    dpayofftax: Date;
    dtimelimittax: Date;
    sremark: string;
    idcreator: number;
    ideditor: number;
    dcreatedatetime: Date;
    deditdatetime: Date;
}
