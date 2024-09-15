INSERT INTO public.user_login(
	user_id, username, password_hash, user_status, created_at)
	VALUES (?, ?, ?, ?, ?);