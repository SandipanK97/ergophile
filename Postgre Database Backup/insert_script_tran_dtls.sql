INSERT INTO public.tran_dtls(
	cust_id, modeoftransaction, amtoftransaction, transactiontype, dot, transactionno, balance, accountno, updateno)
	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);