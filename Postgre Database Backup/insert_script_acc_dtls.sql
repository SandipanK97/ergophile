INSERT INTO public.acc_dtls(
	cust_id, accountno, ifsccd, branch, location, accounttype, status, aod, openingbalance, loanaccountno, loanamt, roi, tenure)
	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);