USE store_cms_plusplus;

-- 1. Trả ra 5 laptop có giá nhỏ nhất.
SELECT * FROM `laptop` ORDER BY `price` ASC LIMIT 5;

-- 2. Trả ra các hãng sản xuất laptop và sắp xếp theo thứ tự Alphabet.
SELECT `maker` FROM `laptop` ORDER BY `maker` ASC;

-- 3.  Viết câu query trả ra doanh số laptop bán được và doanh thu của cửa hàng.
SELECT SUM(`sold`) AS `sold`, SUM(`sold` * `price`) AS `sales` FROM `laptop`;