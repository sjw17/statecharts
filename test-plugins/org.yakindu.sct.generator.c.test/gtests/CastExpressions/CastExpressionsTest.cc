/* Generated by YAKINDU Statechart Tools code generator. */

#include "gtest/gtest.h"
#include "CastExpressions.h"

#include "sc_timer_service.h"



//! The timers are managed by a timer service. */
static sc_unit_timer_service_t timer_service;

static CastExpressions statechart;

class CastExpressionsTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		castExpressions_init(&statechart);
		sc_timer_service_init(
			&timer_service,
			0,
			(sc_run_cycle_fp) &castExpressions_runCycle,
			false,
			200,
			&statechart
		);
	}
};


TEST_F(CastExpressionsTest, CastExpressionTest) {
	castExpressions_enter(&statechart);
	EXPECT_TRUE(castExpressionsIface_get_realValue(&statechart)== 5l);
	EXPECT_TRUE(castExpressionsIface_get_intValue(&statechart)== 5l);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(castExpressionsIface_get_realValue(&statechart)== 15l);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(castExpressions_isStateActive(&statechart, CastExpressions_main_region_C));
	EXPECT_TRUE(castExpressionsIface_get_realValue(&statechart)== 757l);
}


