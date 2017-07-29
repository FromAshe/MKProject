/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject;

/**
 *
 * @author YOHY
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Emu
 */
public final class Members {

    
    private String FName;
    private String MName;
    private String LName;
    private String Bdate;
    private String Wereda;
    private String City;
    private String Kebele;
    private String Hollyname;
    private String Kbk;
    private String Kiname;
    private String Kizemen;
    private String Lskill;
    private String Lskill2;
    private String Lskill3;
    private String Phone;
    private String GField;
    private String Note;
    private String Title;
    private String Resp;
    private String IDNUM;
    

    public Members(String phone) 
    {
        setPhone(phone);
    }
   
    public Members(String skill1,String skill2,String skill3) 
    {
        setLang1(skill1);
         setLang2(skill2);
         setLang3(skill3);
    }
     public Members(String skill1,String skill2) 
    {
        setNote(skill1);
         setTitle(skill2);
         
    }
    public Members(String Hname,String hollybk,String kiname,String kiyear ) 
    {
        setHolly(Hname);
        setBK(hollybk);
        setKN(kiname);
        setKY(kiyear);
    }
//,String mname,String lname,String hname,String sex,String btime,String bplace,String dept,String batch,int block,int dno,String service,String sub,String cname,String ayear,String semister,String hfname,String job,String jobservice,String mobno,String tsiwa
    public Members(String fname,String mname,String lname,String hname,String sex,String btime,String bplace)
    {
        //setIDD(id);
       setFName(fname);
        setMName(mname);
        setLName(lname);
        setBdate(hname);
        setWoreda(sex);
        setCity(btime);
        setKebele(bplace);
       
      

        
    }
     public Members(String fname,String mname,String lname,String hname,String sex,String btime,String bplace,String gfield)
    {
        //setIDD(id);
       setFName(fname);
        setMName(mname);
        setLName(lname);
        setBdate(hname);
        setWoreda(sex);
        setCity(btime);
        setKebele(bplace);
        setGField(gfield);
       
            
    }
     public Members(String fname,String mname,String lname,String hname,String sex,String btime,String bplace,String gfield,String holly)
    {
        //setIDD(id);
       setFName(fname);
        setMName(mname);
        setLName(lname);
        setBdate(hname);
        setWoreda(sex);
        setCity(btime);
        setKebele(bplace);
        setGField(gfield);
        setHolly(holly);
       
      

        
    }
      public Members(String id,String fname,String mname,String lname,String hname,String sex,String resp,String btime,String bplace,String gfield,String holly)
    {
        setIDNO(id);
       setFName(fname);
        setMName(mname);
        setLName(lname);
        setBdate(hname);
        setWoreda(sex);
        setResp(resp);
        setCity(btime);
        setKebele(bplace);
        setGField(gfield);
        setHolly(holly);
       
      

        
    }
        public Members(String fname,String mname,String lname,String hname,String sex,String resp,String btime,String bplace,String gfield,String holly)
    {
       // setIDNO(id);
       setFName(fname);
        setMName(mname);
        setLName(lname);
        setBdate(hname);
        setWoreda(sex);
        setResp(resp);
        setCity(btime);
        setKebele(bplace);
        setGField(gfield);
        setHolly(holly);
       
      

        
    }
      
      public void setIDNO(String id)
      {
          IDNUM = id;
      }
      public String GetIDNO()
      {
          return IDNUM;
      }
    public void setTitle(String id) {
        Title = id;
    }

    public String getTitle() {
        return Title;
    }
    public void setNote(String id) {
        Note = id;
    }

    public String getNote() {
        return Note;
    }

    public void setHolly(String id) {
        Hollyname = id;
    }

    public String getHolly() {
        return Hollyname;
    }
    public void setGField(String id) {
        GField = id;
    }

    public String getGField() {
        return GField;
    }
 public void setKY(String id) {
        Kizemen = id;
    }

    public String getKY() {
        return Kizemen;
    }

     public void setBK(String id) {
        Kbk = id;
    }

    public String getBK() {
        return Kbk;
    }

     public void setKN(String id) {
        Kiname = id;
    }

    public String getKN() {
        return Kiname;
    }

    public void setFName(String fname) {
        FName = fname;
    }

    public String getFName() {
        return FName;
    }

    public void setMName(String mname) {
        MName = mname;
    }

    public String getMName() {
        return MName;
    }
    public void setLName(String lname) {
        LName = lname;
    }

    public String getLName() {
        return LName;
    }
    public void setBdate(String hname) {
        Bdate = hname;
    }

    public String getBdate() {
        return Bdate;
    }
    public void setCity(String sex) {
        City = sex;
    }

    public String getCity() {
        return City;
    }
    public void setWoreda(String btime) {
        Wereda = btime;
    }

    public String getWoreda() {
        return Wereda;
    }
     public void setResp(String btime) {
        Resp = btime;
    }

    public String getResp() {
        return Resp;
    }
    public void setKebele(String bplace) {
        Kebele = bplace;
    }

    public String getKebele() {
        return Kebele;
    }
//    public void setDept(String dept) {
//        Dept = dept;
//    }
//
//    public String getDept() {
//        return Dept;
//    }
//    public void setBatch(String batch) {
//        Batch = batch;
//    }
//
//    public String getBatch() {
//        return Batch;
//    }
//    public void setBlock(int block) {
//        Block = block;
//    }
//
//    public int getBlock() {
//        return Block;
//    }
//    
//   public void setDNo(int dno) {
//        DNo = dno;
//    }
//
//    public int getDNo() {
//        return DNo;
//    }
//    public void setService(String service) {
//        Service = service;
//    }
//
//    public String getService() {
//        return Service;
//    }
//    public void setSubService(String sub) {
//        SubService = sub;
//    }
//
//    public String getSubServic() {
//        return SubService;
//    }
//  
    public void setLang1(String semister) {
        Lskill = semister;
    }

    public String getLang1() {
        return Lskill;
    }
    
    public void setLang2(String semister) {
        Lskill2 = semister;
    }

    public String getLang2() {
        return Lskill2;
    }
    public void setLang3(String semister) {
        Lskill3 = semister;
    }

    public String getLang3() {
        return Lskill3;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPhone() {
        return Phone;
    }
//    public void setJob(String job) {
//        Job = job;
//    }
//
//    public String getJob() {
//        return Job;
//    }
//    public void setJobService(String jobservice) {
//        JobService = jobservice;
//    }
//
//    public String getJobService() {
//        return JobService;
//    }
//    public void setMobNo(String mobno) {
//        MobNo = mobno;
//    }
//
//    public String getMobNO() {
//        return MobNo;
//    }
//    public void setTsiwaSim(String tsiwa) {
//        MobNo = tsiwa;
//    }
//
//    public String getTsiwaSim() {
//        return TsiwaSim;
//    }
   
}
