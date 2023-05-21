import express from "express";
import cors from "cors";
import mysql from "mysql";
import nodemailer from 'nodemailer';


let qry = "";
let setString = "";
let value = "";
let id = 0;
const app = express();
const db = mysql.createConnection({
  host : "127.0.0.1",
  user : "root",
  password : "admin",
  database : "ergo"
});

app.use(cors());
app.use(express.json());

app.get("/", (req,res) => {
    res.json({ message : "connected"});
})


app.get("/allusers", (req, res) => {
  qry= "select * from ergo.ergophile_user";
    db.query(qry,(err,data) => {
        if(err) res.json(err);
        else return res.json(data);
    });
  });



  app.get("/loginProcessing/:id", (req, res) => {
    qry= "select t.user_password from ergo.ergophile_user_login_info t where t.user_email = ?";
    value = req.params.id;
      db.query(qry,value,(err,data) => {
          if(err) res.json(err);
          else return res.json(data);
      });
    });

    app.get("/mailProcessing/:id", (req, res) => {
      qry= "select t.user_password from ergo.ergophile_user_login_info t where t.user_email = ?";
      value = req.params.id;
        db.query(qry,value,(err,data) => {
            if(err) res.json(err);
            else {
              const passDbMail = data[0].user_password;

              try {
                // Create a Nodemailer transporter
                let transporter = nodemailer.createTransport({
                  service: 'Protonmail',
                  auth: {
                    user: 'ksandipan0@protonmail.com',
                    pass: 'Sandipan#97'
                  }
                });
          
                // Send mail with defined transport object
                let info =  transporter.sendMail({
                  from: 'ksandipan0@protonmail.com',
                  to: 'sk.tech.1997@outlook.com',
                  subject: 'No-reply@ Ergophile',
                  text: 'Your Password :'+passDbMail+'\n  .Support team\n Ergophile copyright@2023'
                });
          
                console.log('Email sent:', info.response);
              } catch (error) {
                console.error('Error sending email:', error);
              }


              return res.json(data);

            }
        });
      });

  app.get("/userbyid/:id", (req, res) => {
  qry = "select * from ergo.ergophile_user where user_id = ?";
  value = req.params.id;
    db.query(qry,value,(err,data) => {
        if(err) res.json(err);
        else return res.json(data);
    });
  });


  app.post("/adduser",(req,res) =>{
  qry = "insert into ergo.ergophile_user  (user_id,user_name,user_dateOfBirth,user_gender,user_email,"
    + " user_phone,user_state,user_city,user_college,user_degree,user_degree_marks,user_GradPassoutYear,"
    + " user_school,user_major,user_HS_marks,user_HSpassoutYear,user_skills,user_workExp,user_ExpYears,user_language)"
    + "  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    value = [
        req.body.user_id,
        req.body.user_name,
        req.body.user_dateOfBirth,
        req.body.user_gender,
        req.body.user_email,
        req.body.user_phone,
        req.body.user_state,
        req.body.user_city,
        req.body.user_college,
        req.body.user_degree,
        req.body.user_degree_marks,
        req.body.user_GradPassoutYear,
        req.body.user_school,
        req.body.user_major,
        req.body.user_HS_marks,
        req.body.user_HSpassoutYear,
        req.body.user_skills,
        req.body.user_workExp,
        req.body.user_ExpYears,
        req.body.user_language
    ];
    db.query(qry,value,(err,data) => {

        if(err) res.json(err);
        else return res.json("inserted successfully");
    });
});


  app.delete("/deluser",(req,res) =>{
  qry = "delete from ergo.ergophile_user where user_id = ?";
  value =req.body.user_id;

  db.query(qry,value,(err,data) => {

      if(err) res.json(err);
      else return res.json("deleted successfully");
  });
});



app.listen(8080, () => {
  console.log(`Server is running on port 8080.`);
});