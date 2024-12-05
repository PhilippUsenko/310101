 

 func  DevEleven(value:Int) {
      
      var countOne=0;
      var countTwo=0;
      var i=1;
      var tempvalue=value;

        while tempvalue != 0 {
        if i % 2 == 0 {
            countOne += tempvalue % 10
        } else {
            countTwo += tempvalue % 10
        }
        
        i += 1
        tempvalue /= 10
    }

       if (countOne-countTwo)%11==0
       {
           print("Делится на 11")
       }
       else{
        print(" НЕ Делится на 11")
       }
 }

 DevEleven(value:13)

 
 
 
 
