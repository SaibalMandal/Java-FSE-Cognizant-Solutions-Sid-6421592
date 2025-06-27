
CREATE OR REPLACE PROCEDURE TransferFunds(
  from_account IN NUMBER,
  to_account IN NUMBER,
  amount IN NUMBER
) IS
  from_balance NUMBER;
BEGIN
  SELECT Balance INTO from_balance FROM Accounts WHERE AccountID = from_account FOR UPDATE;

  IF from_balance < amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account.');
  END IF;

  UPDATE Accounts SET Balance = Balance - amount WHERE AccountID = from_account;
  UPDATE Accounts SET Balance = Balance + amount WHERE AccountID = to_account;

  COMMIT;
END;
/
