/* Generated by YAKINDU Statechart Tools code generator. */

#include "gtest/gtest.h"
#include "CKeywords.h"

#include "sc_timer_service.h"



//! The timers are managed by a timer service. */
static sc_unit_timer_service_t timer_service;

static CKeywords statechart;

class CKeywordsTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		cKeywords_init(&statechart);
		sc_timer_service_init(
			&timer_service,
			0,
			(sc_run_cycle_fp) &cKeywords_runCycle,
			false,
			200,
			&statechart
		);
	}
};


TEST_F(CKeywordsTest, CKeywordsTest) {
	cKeywords_enter(&statechart);
	EXPECT_TRUE(cKeywords_isStateActive(&statechart, CKeywords_auto_char));
	cKeywordsIface_raise_auto(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(cKeywords_isStateActive(&statechart, CKeywords_auto_loop));
	EXPECT_TRUE(cKeywords_isStateActive(&statechart, CKeywords_auto_loop_switch_case));
	EXPECT_TRUE(cKeywords_isStateActive(&statechart, CKeywords_auto_loop_switch_case_enum_asm));
}


