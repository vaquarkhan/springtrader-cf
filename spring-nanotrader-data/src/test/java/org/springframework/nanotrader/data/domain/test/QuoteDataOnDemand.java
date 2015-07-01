/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.nanotrader.data.domain.test;

import java.math.BigDecimal;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.nanotrader.data.domain.Quote;
import org.springframework.nanotrader.data.service.QuoteService;
import org.springframework.stereotype.Component;


@Component
@Configurable
public class QuoteDataOnDemand {

	@Autowired
    QuoteService quoteService;

	public Quote getNewTransientQuote(int index) {
        Quote obj = new Quote();
        setChange1(obj, index);
        setCompanyname(obj, index);
        setHigh(obj, index);
        setLow(obj, index);
        setOpen1(obj, index);
        setPrice(obj, index);
        setSymbol(obj, index);
        setVolume(obj, index);
        return obj;
    }

	public void setChange1(Quote obj, int index) {
        BigDecimal change1 = BigDecimal.valueOf(index);
        obj.setChange1(change1);
    }

	public void setCompanyname(Quote obj, int index) {
        String companyname = "companyname_" + index;
        if (companyname.length() > 250) {
            companyname = companyname.substring(0, 250);
        }
        obj.setCompanyname(companyname);
    }

	public void setHigh(Quote obj, int index) {
        BigDecimal high = BigDecimal.valueOf(index);
        if (high.compareTo(new BigDecimal("999999999999.99")) == 1) {
            high = new BigDecimal("999999999999.99");
        }
        obj.setHigh(high);
    }

	public void setLow(Quote obj, int index) {
        BigDecimal low = BigDecimal.valueOf(index);
        if (low.compareTo(new BigDecimal("999999999999.99")) == 1) {
            low = new BigDecimal("999999999999.99");
        }
        obj.setLow(low);
    }

	public void setOpen1(Quote obj, int index) {
        BigDecimal open1 = BigDecimal.valueOf(index);
        if (open1.compareTo(new BigDecimal("999999999999.99")) == 1) {
            open1 = new BigDecimal("999999999999.99");
        }
        obj.setOpen1(open1);
    }

	public void setPrice(Quote obj, int index) {
        BigDecimal price = BigDecimal.valueOf(index);
        if (price.compareTo(new BigDecimal("999999999999.99")) == 1) {
            price = new BigDecimal("999999999999.99");
        }
        obj.setPrice(price);
    }

	public void setSymbol(Quote obj, int index) {
        String symbol = "symbol_" + index;
        if (symbol.length() > 250) {
            symbol = new Random().nextInt(10) + symbol.substring(1, 250);
        }
        obj.setSymbol(symbol);
    }

	public void setVolume(Quote obj, int index) {
        BigDecimal volume = BigDecimal.valueOf(index);
        obj.setVolume(volume);
    }

	public Quote getRandomQuote() {
		return quoteService.findBySymbol("GOOG");
    }

	public boolean modifyQuote(Quote obj) {
        return false;
    }
}
