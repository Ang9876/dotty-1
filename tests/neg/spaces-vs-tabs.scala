object Test with

	if true then
		println(1)   // ok
    println(2)   // error
  	println(3)   // error
	  println(4)   // error
 else ()         // error

	object Test2 with

	    if true then
	      1
	  else 2 // error // error

